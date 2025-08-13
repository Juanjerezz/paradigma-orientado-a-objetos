#  Sistema de Venta de Entradas para Cine

Este proyecto es un sistema de gestión para un complejo de cines que permite registrar películas, funciones, vender entradas, aplicar descuentos y generar reportes de recaudación. Implementado en Java con patrón MVC y Swing para la interfaz gráfica.

---

##  Funcionalidades Principales

-  Selección de sucursal.
-  Registro y consulta de películas.
-  Alta de funciones (horario, sala y película).
-  Visualización de asientos disponibles.
-  Compra de entradas y combos.
-  Aplicación de descuentos por día y tarjeta (La Nación, PAMI, MovieClub, Clarín 365, UADE).
-  Reporte de películas con mayor recaudación.

---

## 🧠 Tecnologías y Herramientas

- Java 17
- Swing (GUI)
- JUnit 5 (Tests)
- Maven
- IDE: IntelliJ IDEA

---

## 🗂 Estructura del Proyecto

```
src/
│
├── Controller/          # Controladores principales (Peliculas, Funciones, Ventas)
├── Modelo/              # Clases de dominio (Pelicula, Funcion, Sala, etc.)
├── Vista/               # Interfaces gráficas con Swing
├── Dto/                 # Data Transfer Objects
└── test/                # Tests unitarios con JUnit
```

---

##  Testing

Los tests se encuentran en `src/test/java` e incluyen pruebas para:

- Registro de películas y funciones.
- Validaciones de existencia.
- Consultas de películas.

Ejemplo de test:

```java
@Test
void altaPeliculaYFuncionTest() {
    peliculasController.registrarPelicula(102, "Avatar", TipoGenero.Terror, 150, "James Cameron");
    funcionController.RegistrarFuncion(999, "Avatar", new Date(), "22:00", 5);
    boolean encontrada = funcionController.getFunciones().stream()
        .anyMatch(f -> f.getPelicula().getNombrePelicula().equals("Avatar"));
    assertTrue(encontrada);
}
```

---

## 🛠 Cómo ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tpo-cine.git
   cd tpo-cine
   ```

2. Abrir el proyecto en IntelliJ IDEA.

3. Ejecutar `MenuPrincipal.java` para iniciar la aplicación.

4. Para correr los tests:
   - Usar el panel de tests de IntelliJ IDEA.
   - O desde Maven:
     ```bash
     mvn test
     ```

---
