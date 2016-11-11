# JavaMail

Simple example of sending e-mail with SMTP protocol using the JavaMail API and the MailTrap service.

# How to use

Update the client's source at:
src/main/java/br/com/thiaguten/javamail/client/standalone/Main.java
by adding the desired origin and destiny e-mail addresses (by default, a MailTrap SMTP configuration is beign used). To execute the example:

```bash
mvn exec:java -Dexec.mainClass= br.com.thiaguten.javamail.client.standalone.Main
```

## Attention:
The e-mail user and password parameters must be set in the e-mail configuration properties file called `javamail.properties` as  `mail.user` and `mail.password` located by default in `src/main/resources`. 