# Dishcovery

Dishcovery es una aplicación Android moderna para descubrir y guardar recetas de cocina, desarrollada con las mejores prácticas y tecnologías actuales.

## Estado Actual del Proyecto

El proyecto se encuentra en desarrollo activo, implementándose en fases secuenciales. Actualmente se está trabajando en la integración de los componentes fundamentales de la arquitectura.

### Fases de Implementación

1. **Fase Retrofit** *(Completada)*
   - Integración con TheMealDB API
   - Implementación de servicios REST
   - Manejo de respuestas HTTP
   - Conversión de JSON a objetos Kotlin

2. **Fase Room** *(En Progreso)*
   - Base de datos local para recetas favoritas
   - Entidades y DAOs
   - Operaciones CRUD
   - Persistencia de datos offline

3. **Fase Hilt** *(Planificada)*
   - Inyección de dependencias
   - Módulos de base de datos
   - Módulos de red
   - Módulos de repositorio

4. **Fase Firebase** *(Futura)*
   - Autenticación de usuarios
   - Almacenamiento en la nube
   - Análisis y métricas
   - Notificaciones push

## Estructura del Proyecto

```
app/
├── api/
│   └── MealService.kt         # Interfaz para llamadas a la API
├── database/
│   ├── RecipeDao.kt          # Data Access Object para recetas
│   └── RecipeDatabase.kt     # Configuración de la base de datos Room
├── di/
│   ├── DatabaseModule.kt     # Módulo Hilt para la base de datos
│   ├── NetworkModule.kt      # Módulo Hilt para servicios de red
│   └── RepositoryModule.kt   # Módulo Hilt para repositorios
├── model/
│   └── Recipe.kt            # Modelos de datos
├── repository/
│   └── RecipeRepository.kt  # Repositorio para gestión de datos
└── viewmodel/
    └── RecipeViewModel.kt   # ViewModel para la UI
```

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje principal de desarrollo
- **Jetpack Compose**: UI moderna y declarativa
- **Coroutines**: Programación asíncrona
- **Flow**: Streams de datos reactivos
- **Retrofit**: Cliente HTTP para Android
- **Room**: Persistencia de datos local
- **Hilt**: Inyección de dependencias
- **Coil**: Carga de imágenes
- **Navigation Compose**: Navegación entre pantallas

## Características

- Búsqueda de recetas
- Visualización detallada de recetas
- Guardado de recetas favoritas
- Soporte offline
- Interfaz moderna y responsive

## Requisitos

- Android Studio Arctic Fox o superior
- Android SDK 24 o superior
- Kotlin 1.5.0 o superior

## Configuración del Proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/jaennova/dishcovery.git
```

2. Abrir el proyecto en Android Studio

3. Sincronizar el proyecto con Gradle

4. Ejecutar la aplicación

## Ramas del Proyecto

- `main`: Código estable y producción
- `feature/retrofit`: Implementación de servicios REST
- `feature/room`: Implementación de base de datos local
- `feature/hilt`: Implementación de inyección de dependencias
- `feature/firebase`: (Futura) Implementación de servicios Firebase

## Contribución

1. Fork del repositorio
2. Crear una rama para tu feature (`git checkout -b feature/amazing-feature`)
3. Commit de tus cambios (`git commit -m 'Add some amazing feature'`)
4. Push a la rama (`git push origin feature/amazing-feature`)
5. Abrir un Pull Request

## Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## Contacto

Jaen Nova - [@jaennova](https://github.com/jaennova)

Link del proyecto: [https://github.com/jaennova/dishcovery](https://github.com/jaennova/dishcovery)

---

**Nota**: Este proyecto está en desarrollo activo y la documentación se actualiza regularmente conforme se implementan nuevas características.
