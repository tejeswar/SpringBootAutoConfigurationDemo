package com.in28minutes.springboot.web;

import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.lightstep.tracer.jre.JRETracer;
import com.lightstep.tracer.shared.Options;

import io.opentracing.Span;

@SpringBootApplication
@ComponentScan("com.in28minutes.springboot.web")
public class SpringBootFirstWebApplication extends SpringBootServletInitializer { // AWS

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootFirstWebApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
		
		
		 Options opts = new Options.OptionsBuilder()
		            .withAccessToken("IFebOQE4y9or6C4KQAcgGVpqpxrWc7pjIClaxaReFTgMTFIDN0pExGcCY1P0dPtRD90vjCdZXfxiDQAxQNalH3nPiJcSs220CBPd1uPK")
		            .withComponentName("todo-service")
		            .build();

		        JRETracer tracer = new JRETracer(opts);

		        Span span = tracer.buildSpan("handler").start();//span name = handler
		        span.setTag("kind", "server");
		        span.log("What a lovely day");
		        span.finish();

		        tracer.flush(500);
	}

}
