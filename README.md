# JavaMail

Simple example of sending e-mail with SMTP protocol using the JavaMail API.

## Attention:
The e-mail user and password parameters must be set in the e-mail configuration properties file called `javamail.properties` as  `mail.user` and `mail.password` located by default in `src/main/resources`. You can override the location of the e-mail configuration properties file through the environment variable called `EMAIL_CONFIG_DIR`.