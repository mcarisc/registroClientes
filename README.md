# Sistema de Registro de Clientes 👥

Una aplicación web para la gestión y registro de clientes desarrollada con Spring Boot y Thymeleaf.

## 🚀 Características

- **CRUD completo**: Crear, leer, actualizar y eliminar registros de clientes
- **Interfaz web responsiva**: Desarrollada con Thymeleaf y Bootstrap
- **Validación de datos**: Validación tanto en frontend como backend
- **Persistencia de datos**: Integración con base de datos usando Spring Data JPA
- **Arquitectura MVC**: Separación clara entre modelo, vista y controlador

## 🛠️ Tecnologías Utilizadas

- **Backend**: Spring Boot 3.x
- **Frontend**: Thymeleaf, HTML5, CSS3, Bootstrap
- **Base de datos**: Spring Data JPA, Hibernate
- **Construcción**: Maven
- **Java**: JDK 17+

## 📋 Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- **Java JDK 17** o superior
- **Maven 3.6+**
- **MySQL/MariaDB** (o la base de datos que uses)
- **Git**

## 🔧 Instalación y Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/mcarisc/registroClientes.git
cd registroClientes
```

### 2. Configurar la base de datos
Edita el archivo `src/main/resources/application.properties`:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/registro_clientes
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3. Crear la base de datos
```sql
CREATE DATABASE registro_clientes;
```

### 4. Instalar dependencias y ejecutar
```bash
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 💻 Uso

### Funcionalidades principales:

1. **Listar clientes**: Visualiza todos los clientes registrados
2. **Agregar cliente**: Formulario para registrar nuevos clientes
3. **Editar cliente**: Modificar información de clientes existentes
4. **Eliminar cliente**: Remover clientes del sistema
5. **Búsqueda**: Buscar clientes por diferentes criterios

### Navegación:
- **Página principal**: `/` o `/clientes`
- **Nuevo cliente**: `/clientes/nuevo`
- **Editar cliente**: `/clientes/editar/{id}`
- **Ver detalles**: `/clientes/{id}`

## 📁 Estructura del Proyecto

```
registroClientes/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ejemplo/
│   │   │           └── registroclientes/
│   │   │               ├── controller/
│   │   │               │   └── ClienteController.java
│   │   │               ├── model/
│   │   │               │   └── Cliente.java
│   │   │               ├── repository/
│   │   │               │   └── ClienteRepository.java
│   │   │               ├── service/
│   │   │               │   └── ClienteService.java
│   │   │               └── RegistroClientesApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── images/
│   │       ├── templates/
│   │       │   ├── clientes/
│   │       │   │   ├── lista.html
│   │       │   │   ├── formulario.html
│   │       │   │   └── detalle.html
│   │       │   └── layout/
│   │       │       └── base.html
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 📊 Modelo de Datos

### Entidad Cliente
```java
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @Email
    private String email;
    
    private String telefono;
    
    private String direccion;
    
    @CreationTimestamp
    private LocalDateTime fechaRegistro;
    
    // Getters y setters
}
```

## 🧪 Pruebas

Para ejecutar las pruebas:
```bash
mvn test
```

Para ejecutar con cobertura:
```bash
mvn test jacoco:report
```

## 🚀 Despliegue

### Generar JAR ejecutable:
```bash
mvn clean package
java -jar target/registroClientes-1.0.0.jar
```

### Docker (opcional):
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/registroClientes-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🛡️ Seguridad

- Validación de datos en formularios
- Protección contra inyección SQL usando JPA
- Validación de campos obligatorios
- Manejo de errores HTTP

## 🤝 Contribuir

1. Haz un fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Realiza tus cambios y haz commit (`git commit -m 'Agrega nueva característica'`)
4. Sube los cambios (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## 📋 Roadmap

- [ ] Implementar autenticación y autorización
- [ ] Agregar filtros y búsqueda avanzada
- [ ] Exportar datos a Excel/PDF
- [ ] API REST para integración con otros sistemas
- [ ] Paginación para grandes volúmenes de datos
- [ ] Auditoría de cambios

## 🐛 Problemas Conocidos

- Reporta cualquier error creando un [issue](https://github.com/mcarisc/registroClientes/issues)

## 📝 Changelog

### [1.0.0] - 2025-01-XX
- ✅ CRUD básico de clientes
- ✅ Interfaz web con Thymeleaf
- ✅ Validación de formularios
- ✅ Persistencia con JPA

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**mcarisc** - [GitHub](https://github.com/mcarisc)

## 📞 Contacto

Si tienes preguntas o sugerencias, no dudes en contactarme:

- GitHub: [@mcarisc](https://github.com/mcarisc)
- Issues: [Reportar un problema](https://github.com/mcarisc/registroClientes/issues)

## 🙏 Agradecimientos

- Spring Boot Team por el excelente framework
- Thymeleaf por el motor de plantillas
- Bootstrap por los componentes UI

---

⭐ **¡Dale una estrella si este proyecto te fue útil!**
