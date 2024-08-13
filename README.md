# requester

$JAVA_HOME/lib/security/cacerts

keytool -list -keystore $JAVA_HOME/lib/security/cacerts
The default password is “changeit”

openssl s_client -showcerts -connect vstde-a.estv.admin.ch:443

openssl s_client -showcerts -connect self-signed.badssl.com:443


java -Djavax.net.debug=all -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=9090 -jar http11.jar https://vstde-a.estv.admin.ch/

java -Djavax.net.debug=all -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=9090 -jar http11.jar https://self-signed.badssl.com


javax.net.ssl|DEBUG|0D|HttpClient-1-Worker-0|2021-02-17 17:42:51.549 CET|CertificateMessage.java:357|Consuming server Certificate handshake message (

javax.net.ssl|DEBUG|0D|HttpClient-1-Worker-0|2021-02-17 17:42:51.593 CET|X509TrustManagerImpl.java:292|Found trusted certificate (

java -Djavax.net.debug=all -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=9090 -jar http11.jar https://self-signed.badssl.com > output.txt 2>&1


keytool -import -alias vp_estv -file "C:\Users\confinale\Desktop\mycert2.cer" -keystore "C:\Program Files\Java\openjdk-11+28_windows-x64_bin\jdk-11\lib\security\cacerts"

certmgr.msc


java -Djavax.net.debug=all -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=9090 -Djavax.net.ssl.trustStoreType=Windows-ROOT -Djavax.net.ssl.trustStore=NONE -jar http11.jar https://vstde-a.estv.admin.ch/start > windowscerts.txt 2>&1
