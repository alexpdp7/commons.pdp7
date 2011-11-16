package net.pdp7.commons.facebook;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class FacebookService {

	protected String appId;
	protected String appSecret;

	public FacebookService(String appId, String appSecret) {
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public Token obtainAccessToken(String code, String callBackUri) {
		return createOAuthService(callBackUri).getAccessToken(null, new Verifier(code));
	}
	
	public <T> T makeRequest(Verb verb, String url, Token accessToken, String callBackUri, Class<? extends T> responseMapClass) throws IOException {
		OAuthRequest request = new OAuthRequest(verb, url);
		createOAuthService(callBackUri).signRequest(accessToken, request);
		Response response = request.send();
		return new ObjectMapper().readValue(response.getBody(), responseMapClass);
	}

	protected OAuthService createOAuthService(String callBackUri) {
		return new ServiceBuilder()
				.provider(FacebookApi.class)
				.apiKey(appId)
				.apiSecret(appSecret)
				.callback(callBackUri).build();
	}
	
	public String buildLoginUrl(String callbackUri) {
		try {
			return "https://www.facebook.com/dialog/oauth?client_id=" + appId + "&redirect_uri=" + URLEncoder.encode(callbackUri, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
