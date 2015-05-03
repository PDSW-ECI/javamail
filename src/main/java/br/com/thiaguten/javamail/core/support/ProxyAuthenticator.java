package br.com.thiaguten.javamail.core.support;

public class ProxyAuthenticator extends java.net.Authenticator {

    /**
     * the host name of the proxy server
     */
    public static final String PROXY_HOST = "proxyHost";

    /**
     * the port number, the default value being 80 (http) or 443 (https)
     */
    public static final String PROXY_PORT = "proxyPort";

    /**
     * a list of hosts that should be reached directly, bypassing the proxy
     */
    public static final String NON_PROXY_HOSTS = "nonProxyHosts";

    /**
     * the user of the proxy server
     */
    public static final String PROXY_USER = "proxyUser";

    /**
     * the user password of the proxy server
     */
    public static final String PROXY_PASSWORD = "proxyPassword";

    /**
     * host name of the SOCKS proxy server
     */
    public static final String SOCKS_PROXY_HOST = "socksProxyHost";

    /**
     * port number, the default value being 1080
     */
    public static final String SOCKS_PROXY_PORT = "socksProxyPort";

    private final String proxyHost, proxyPort, proxyBypass, proxyUser, proxyPassword;

    public ProxyAuthenticator(final String proxyHost, final String proxyPort) {
        this(proxyHost, proxyPort, null);
    }

    public ProxyAuthenticator(final String proxyHost, final String proxyPort, final String proxyBypass) {
        this(proxyHost, proxyPort, proxyBypass, null, null);
    }

    public ProxyAuthenticator(final String proxyHost, final String proxyPort, final String proxyBypass, final String proxyUser, final String proxyPassword) {
        if (proxyHost == null || proxyHost.trim().isEmpty() || proxyPort == null || proxyPort.trim().isEmpty())
            throw new IllegalArgumentException("proxyHost and proxyPort must not be null");

        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyBypass = proxyBypass;
        this.proxyUser = proxyUser;
        this.proxyPassword = proxyPassword;
    }

    @Override
    protected java.net.PasswordAuthentication getPasswordAuthentication() {
        if (RequestorType.PROXY.equals(getRequestorType())) {

            /**
             * What happens when both a SOCKS proxy and a HTTP proxy are defined?
             *
             * Well the rule is that settings for higher level protocols, like HTTP or FTP, take precedence over SOCKS settings.
             * So, in that particular case, when establishing a HTTP connection, the SOCKS proxy settings will be ignored and
             * the HTTP proxy will be contacted.
             *
             * http://docs.oracle.com/javase/6/docs/technotes/guides/net/proxies.html
             */
            String host = System.setProperty(SOCKS_PROXY_HOST, proxyHost);
            String port = System.setProperty(SOCKS_PROXY_PORT, proxyPort);

            String protocol = getRequestingProtocol() + ".";

            if ("http.".equalsIgnoreCase(protocol) || "https.".equalsIgnoreCase(protocol) || "ftp.".equalsIgnoreCase(protocol)) {
                host = System.setProperty(protocol + PROXY_HOST, proxyHost);
                port = System.setProperty(protocol + PROXY_PORT, proxyPort);

                System.setProperty(protocol + NON_PROXY_HOSTS, proxyBypass);
            }

            final String user = System.setProperty(protocol + PROXY_USER, proxyUser);
            final String password = System.setProperty(protocol + PROXY_PASSWORD, proxyPassword);

            if (getRequestingHost().equalsIgnoreCase(host)) {
                if (getRequestingPort() == Integer.parseInt(port)) {
                    return new java.net.PasswordAuthentication(user, password.toCharArray());
                }
            }

        }
        return super.getPasswordAuthentication();
    }
}
