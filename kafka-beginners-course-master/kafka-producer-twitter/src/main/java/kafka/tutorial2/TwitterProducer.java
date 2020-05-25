package kafka.tutorial2;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
https://github.com/twitter/hbc

cd /Users/tsahu/AllWorkspaces/SpringBootApplWorkSpaces/TestWS/kafka-beginners-course-master/kafka-producer-twitter
mvn exec:java -Dexec.mainClass="kafka.tutorial2.TwitterProducer"  



one twitter record format

{"created_at":"Fri Mar 20 09:59:51 +0000 2020","id":1240941112312856576,"id_str":"1240941112312856576","text":"RT @CNBC: Cryptocurrencies rise $23.8 billion in 24 hours as bitcoin jumps near 16% https:\/\/t.co\/OerZ2i3jjh","source":"\u003ca href=\"http:\/\/twitter.com\/download\/android\" rel=\"nofollow\"\u003eTwitter for Android\u003c\/a\u003e","truncated":false,"in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":562479676,"id_str":"562479676","name":"Adam Delgado","screen_name":"omniscientAPE","location":null,"url":null,"description":"\ud83c\udf15\ud83c\udf0c\ud83d\ude80\ud83d\udef8","translator_type":"none","protected":false,"verified":false,"followers_count":744,"friends_count":4656,"listed_count":1,"favourites_count":23869,"statuses_count":5191,"created_at":"Wed Apr 25 01:08:16 +0000 2012","utc_offset":null,"time_zone":null,"geo_enabled":false,"lang":null,"contributors_enabled":false,"is_translator":false,"profile_background_color":"C0DEED","profile_background_image_url":"http:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_image_url_https":"https:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_tile":false,"profile_link_color":"1DA1F2","profile_sidebar_border_color":"C0DEED","profile_sidebar_fill_color":"DDEEF6","profile_text_color":"333333","profile_use_background_image":true,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/1238216936577777670\/NmXRJwPF_normal.jpg","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/1238216936577777670\/NmXRJwPF_normal.jpg","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/562479676\/1571406559","default_profile":true,"default_profile_image":false,"following":null,"follow_request_sent":null,"notifications":null},"geo":null,"coordinates":null,"place":null,"contributors":null,"retweeted_status":{"created_at":"Fri Mar 20 02:30:12 +0000 2020","id":1240827956525707266,"id_str":"1240827956525707266","text":"Cryptocurrencies rise $23.8 billion in 24 hours as bitcoin jumps near 16% https:\/\/t.co\/OerZ2i3jjh","source":"\u003ca href=\"http:\/\/www.socialflow.com\" rel=\"nofollow\"\u003eSocialFlow\u003c\/a\u003e","truncated":false,"in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":20402945,"id_str":"20402945","name":"CNBC","screen_name":"CNBC","location":"Englewood Cliffs, NJ","url":"https:\/\/www.cnbc.com\/","description":"First in business worldwide.","translator_type":"none","protected":false,"verified":true,"followers_count":3476873,"friends_count":801,"listed_count":29737,"favourites_count":584,"statuses_count":342682,"created_at":"Mon Feb 09 00:03:41 +0000 2009","utc_offset":null,"time_zone":null,"geo_enabled":true,"lang":null,"contributors_enabled":false,"is_translator":false,"profile_background_color":"0D181F","profile_background_image_url":"http:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_image_url_https":"https:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_tile":false,"profile_link_color":"2D648A","profile_sidebar_border_color":"FFFFFF","profile_sidebar_fill_color":"EAEBEA","profile_text_color":"333333","profile_use_background_image":true,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/1185182366156894208\/pKRddT3o_normal.png","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/1185182366156894208\/pKRddT3o_normal.png","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/20402945\/1533568341","default_profile":false,"default_profile_image":false,"following":null,"follow_request_sent":null,"notifications":null},"geo":null,"coordinates":null,"place":null,"contributors":null,"is_quote_status":false,"quote_count":8,"reply_count":19,"retweet_count":120,"favorite_count":207,"entities":{"hashtags":[],"urls":[{"url":"https:\/\/t.co\/OerZ2i3jjh","expanded_url":"https:\/\/cnb.cx\/33vpknQ","display_url":"cnb.cx\/33vpknQ","indices":[74,97]}],"user_mentions":[],"symbols":[]},"favorited":false,"retweeted":false,"possibly_sensitive":false,"filter_level":"low","lang":"en"},"is_quote_status":false,"quote_count":0,"reply_count":0,"retweet_count":0,"favorite_count":0,"entities":{"hashtags":[],"urls":[{"url":"https:\/\/t.co\/OerZ2i3jjh","expanded_url":"https:\/\/cnb.cx\/33vpknQ","display_url":"cnb.cx\/33vpknQ","indices":[84,107]}],"user_mentions":[{"screen_name":"CNBC","name":"CNBC","id":20402945,"id_str":"20402945","indices":[3,8]}],"symbols":[]},"favorited":false,"retweeted":false,"possibly_sensitive":false,"filter_level":"low","lang":"en","timestamp_ms":"1584698391403"}
 
*/
public class TwitterProducer {

    Logger logger = LoggerFactory.getLogger(TwitterProducer.class.getName());

    // use your own credentials - don't share them with anyone
    String consumerKey = "LZCrkf2FJRda0sEtFv009KcKT";
    String consumerSecret = "oPIDD5vb8bSUOD0NlAukloDX1uC7wEelTxZ4v6bkaA1xjXWLNJ";
    String token = "1023504328428937216-tNdx2QTCgJeygYFtCq1YFhCrx23whJ";
    String secret = "Mtz1fglcORVI0u0101Qj5MbGDR0gFeLHycN6CeTPuj6io";

    List<String> terms = Lists.newArrayList("bitcoin", "usa", "politics", "sport", "soccer");


    public TwitterProducer(){}

    public static void main(String[] args) {
        new TwitterProducer().run();
    }

    public void run(){

        logger.info("Setup");

        /** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(1000);

        // create a twitter client
        Client client = createTwitterClient(msgQueue);
        // Attempts to establish a connection.
        client.connect();

        // create a kafka producer
        KafkaProducer<String, String> producer = createKafkaProducer();

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("stopping application...");
            logger.info("shutting down client from twitter...");
            client.stop();
            logger.info("closing producer...");
            producer.close();
            logger.info("done!");
        }));

        // loop to send tweets to kafka
        // on a different thread, or multiple different threads....
        while (!client.isDone()) {
            String msg = null;
            try {
                msg = msgQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                client.stop();
            }
            if (msg != null){
                logger.info(msg);
                producer.send(new ProducerRecord<>("twitter_tweets", null, msg), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (e != null) {
                            logger.error("Something bad happened", e);
                        }
                    }
                });
            }
        }
        logger.info("End of application");
    }

    public Client createTwitterClient(BlockingQueue<String> msgQueue){

        /** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

        hosebirdEndpoint.trackTerms(terms);

        // These secrets should be read from a config file
        Authentication hosebirdAuth = new OAuth1(consumerKey, consumerSecret, token, secret);

        ClientBuilder builder = new ClientBuilder()
                .name("Hosebird-Client-01")                              // optional: mainly for the logs
                .hosts(hosebirdHosts)
                .authentication(hosebirdAuth)
                .endpoint(hosebirdEndpoint)
                .processor(new StringDelimitedProcessor(msgQueue));

        Client hosebirdClient = builder.build();
        return hosebirdClient;
    }

    public KafkaProducer<String, String> createKafkaProducer(){
        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create safe Producer
        properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5"); // kafka 2.0 >= 1.1 so we can keep this as 5. Use 1 otherwise.

        // high throughput producer (at the expense of a bit of latency and CPU usage)
        properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32*1024)); // 32 KB batch size

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        return producer;
    }
}
