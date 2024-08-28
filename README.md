# JDBC-Education-SpringBoot3.2

Este documento ofrece una visión general de los conceptos clave de JDBC, enfocándose en las operaciones CRUD utilizando **JdbcTemplate**, comparando el *Cliente JDBC* con *Spring Data JDBC*, y discutiendo las ventajas y desventajas de cada enfoque.

## Contenido

1. [Operaciones CRUD Básicas con JdbcTemplate](#1-operaciones-crud-básicas-con-jdbctemplate)
2. [Comparativa: Cliente JDBC vs Spring Data JDBC](#2-comparativa-cliente-jdbc-vs-spring-data-jdbc)
3. [Ventajas y Desventajas](#3-ventajas-y-desventajas)

## 1. Operaciones CRUD con **JdbcTemplate**

En esta sección se muestran ejemplos prácticos de cómo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) utilizando **JdbcTemplate** en un repositorio.

- **Introducción a JDBC:** Explicación de los conceptos fundamentales de JDBC y su relación con las bases de datos.
- **Enfoque DB-First:** Descripción del enfoque DB-First y su importancia en el desarrollo.
- **Rendimiento vs. CQRS:** Exploración de cómo JdbcTemplate equilibra el rendimiento con los principios de la segregación de responsabilidades de comandos y consultas (CQRS).

## 2. Comparativa: *Cliente JDBC* vs *Spring Data JDBC*

Aquí comparamos el *Cliente JDBC* con *Spring Data JDBC* para comprender sus diferencias en la gestión de operaciones con bases de datos.

- **Gestión de Agregados:** Análisis profundo sobre cómo se gestionan los agregados en cada enfoque. Puedes ver un [video explicativo](https://youtu.be/l_T0nQNbFiM?si=zB1iI2eHiEzIkcDr) para una discusión detallada.

### Cliente JDBC (`org.springframework.jdbc.core`):

- Ejecuta consultas y actualizaciones en JDBC de manera eficiente.
- Captura excepciones y las traduce a una jerarquía de excepciones de DAO.
- Ofrece interfaces de callback con `PreparedStatements` y `RowMappers` para mayor control.

```java
private final JdbcClient jdbcClient;
```

## 3. Ventajas y Desventajas

### **Ventajas:**
- **Rendimiento:** Control directo sobre la ejecución de SQL para un rendimiento optimizado.
- **Control:** Control detallado sobre las consultas SQL y el procesamiento de resultados.

### **Desventajas:**
- **Código Verboso:** Requiere más código en comparación con frameworks de nivel superior como JPA.
- **RowMappers:** Necesidad de implementar `RowMapper` personalizados, lo que añade complejidad.