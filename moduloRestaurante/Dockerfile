# Usa la imagen ligera de JRE 17 Alpine
# Esta imagen no necesita código fuente ni pom.xml para funcionar.
FROM eclipse-temurin:17-jre-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Crea un pequeño script de shell que confirma que el entorno está listo
RUN echo '#!/bin/sh' > /app/test_script.sh
RUN echo "echo '*****************************************************'" >> /app/test_script.sh
RUN echo "echo '¡Imagen JDK 17 creada con éxito!'" >> /app/test_script.sh
RUN echo "echo '*****************************************************'" >> /app/test_script.sh

# Da permisos de ejecución al script
RUN chmod +x /app/test_script.sh

# El comando que se ejecuta al iniciar el contenedor
# El contenedor se iniciará, imprimirá el mensaje y se detendrá.
ENTRYPOINT ["/app/test_script.sh"]