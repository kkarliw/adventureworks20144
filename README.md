# Taller: Conexión JDBC a PRLR (CTU Prague)
Este proyecto conecta **Java (JDBC)** con una base de datos del **Prague Relational Learning Repository (PRLR)**.  
La base seleccionada fue **AdventureWorks2014**.

## Contenido del repositorio
- `src/` → Código fuente en Java con conexión JDBC.  
- `pom.xml` → Configuración de Maven y dependencias (MySQL Connector/J).  
- `consultas.sql` → Script con las consultas SQL realizadas.  
- `Bitacora.pdf` → Documento con la bitácora, problemas/soluciones y capturas de evidencia.  
- `README.md` → Este archivo con instrucciones de ejecución.  

## Requisitos previos
- **Java 17** o superior  
- **Maven** instalado  
- Conexión a internet (para acceder al servidor PRLR)
- 
## Datos de conexión
- **Host:** relational.fel.cvut.cz  
- **Puerto:** 3306  
- **Usuario:** guest  
- **Contraseña:** ctu-relational  
- **Base utilizada:** AdventureWorks2014  

## Ejecución del proyecto
1. Clonar este repositorio:  
   ```bash
   git clone https://github.com/usuario/repositorio.git
