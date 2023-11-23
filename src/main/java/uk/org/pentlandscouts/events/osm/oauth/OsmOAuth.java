package uk.org.pentlandscouts.events.osm.oauth;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

/**
 * Class to get an Authorised token from OSM
 */
public class OsmOAuth{

    private static Logger LOGGER = LoggerFactory.getLogger(OsmOAuth.class);
    private static final String OSM_AUTH_URL = "https://www.onlinescoutmanager.co.uk/oauth/authorize";
    private static final String CLIENT_ID = "PTNSe6evvaPVQcYeRbd3UDlEysg25xS9";

    private static final String SECRET_ID = "TEnh7DzPedqKUthwGInEiytlx2ThmvCXscAjwI7mQSDdmaROL1htuNVBDDoZSDdc";

    private static final String URL = "http://localhost:8080";

    public static void main(String[] args)
    {
        OsmOAuth osmOAuth = new OsmOAuth();
        LOGGER.info("Authorising OSM: {}",osmOAuth.authoriseOSM());
        System.out.println("Testing...");
    }


    public int authoriseOSM()
    {
        HttpServletResponse response = new HttpServletResponse() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public String encodeURL(String s) {
                return null;
            }

            @Override
            public String encodeRedirectURL(String s) {
                return null;
            }

            @Override
            public void sendError(int i, String s) throws IOException {

            }

            @Override
            public void sendError(int i) throws IOException {

            }

            @Override
            public void sendRedirect(String s) throws IOException {

            }

            @Override
            public void setDateHeader(String s, long l) {

            }

            @Override
            public void addDateHeader(String s, long l) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setIntHeader(String s, int i) {

            }

            @Override
            public void addIntHeader(String s, int i) {

            }

            @Override
            public void setStatus(int i) {

            }

            @Override
            public int getStatus() {
                return 0;
            }

            @Override
            public String getHeader(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaders(String s) {
                return null;
            }

            @Override
            public Collection<String> getHeaderNames() {
                return null;
            }

            @Override
            public String getCharacterEncoding() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return null;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return null;
            }

            @Override
            public void setCharacterEncoding(String s) {

            }

            @Override
            public void setContentLength(int i) {

            }

            @Override
            public void setContentLengthLong(long l) {

            }

            @Override
            public void setContentType(String s) {

            }

            @Override
            public void setBufferSize(int i) {

            }

            @Override
            public int getBufferSize() {
                return 0;
            }

            @Override
            public void flushBuffer() throws IOException {

            }

            @Override
            public void resetBuffer() {

            }

            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void reset() {

            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }
        };
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try
        {
            OAuthClientRequest request = OAuthClientRequest
                    // providing the Strava authorization endpoint,
                    .authorizationLocation(OSM_AUTH_URL)
                    // setting the Client ID of your registered application,
                    .setClientId(CLIENT_ID)
                    // setting response type to code,
                    .setResponseType("code")
                    // setting scope to view_private (optional),
                    .setScope("activity:read")
                    // setting the redirect URI back to the servlet.
                    .setRedirectURI(URL).buildQueryMessage();

            String body = request.getBody();
            response.sendRedirect(request.getLocationUri());
            return response.getStatus();

    } catch (OAuthSystemException e) {
        LOGGER.error("OAuthSystemException: {}" , e.getMessage());
    }  catch (IOException e) {
            LOGGER.error("IOException: {}" , e.getMessage());
        }
      return -1;
    }
}
