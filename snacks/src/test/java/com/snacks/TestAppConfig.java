package com.snacks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by xuwushun on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OfficepageApplication.class)
public class TestAppConfig {
	private MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext webApplicationContext;

	@Before
	@Test
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	public void testGet(String uri) throws Exception {
		mockMvc.perform(get(uri)).andDo(print());
	}

	public void testGet(String uri, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(get(uri).headers(httpHeaders)).andDo(print());
	}

	public void testGet(String uri, String body, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).accept(MediaType.APPLICATION_JSON).content(body)).andDo(print());
	}

	public void testPost(String uri, String body, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).accept(MediaType.APPLICATION_JSON).content(body)).andDo(print());
	}

	public void testPost(String uri, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).accept(MediaType.APPLICATION_JSON)).andDo(print());
	}

	public void testPostTextPlain(String uri, String body) throws Exception {
		mockMvc.perform(post(uri).contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).content(body)).andDo(print());
	}

	public void testPost(String uri, String body) throws Exception {
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(body)).andDo(print());
	}

	public void testPut(String uri, String body) throws Exception {
		mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(body)).andDo(print());
	}

	public void testPut(String uri, String body, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON).headers(httpHeaders).accept(MediaType.APPLICATION_JSON).content(body)).andDo(print());
	}

	public void testMultipartPost(String uri, MockMultipartFile body, HttpHeaders httpHeaders) throws Exception {
		mockMvc.perform(multipart(uri).file(body).contentType(MediaType.MULTIPART_FORM_DATA).headers(httpHeaders).accept(MediaType.APPLICATION_JSON)).andDo(print());
	}
}
