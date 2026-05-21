# The Simpson App

Una aplicación de Android que muestra una lista de personajes de Los Simpson consumiendo la API externa de [The Simpsons API](https://thesimpsonsapi.com/).

## 🚀 Características
* Muestra un listado de personajes que incluye su imagen, nombre y ocupación.
* Navegación a una pantalla de detalles (`SimpsonDetailFragment`) para ver la información de cada personaje de forma individual.
* Manejo de estados de la interfaz de usuario (Carga, Éxito y Errores de red o de búsqueda).

## 🛠️ Tecnologías y Arquitectura
El proyecto está desarrollado completamente en **Kotlin** y está estructurado utilizando el patrón **MVVM (Model-View-ViewModel)** junto con principios de **Clean Architecture** (división en capas de Domain, Data y Presentation).

* **UI y Navegación:**
  * [Navigation Component](https://developer.android.com/guide/navigation) para gestionar el flujo y la navegación entre las diferentes pantallas de la aplicación.
  * [Coil](https://coil-kt.github.io/coil/) para la carga y el almacenamiento en caché de imágenes de forma asíncrona.
  * **ViewBinding** para una interacción segura y directa con las vistas de los *layouts*.
* **Programación Asíncrona:**
  * Uso de **Coroutines** y **StateFlow** para el manejo de tareas en segundo plano y la actualización reactiva de la interfaz gráfica.
* **Red y Datos:**
  * [Retrofit](https://square.github.io/retrofit/) para las peticiones HTTP a la API de los personajes.
  * **Gson** para la serialización y deserialización de los datos JSON.

## 📋 Requisitos Previos
Para poder compilar y ejecutar este proyecto, necesitarás:
* Android Studio (se recomienda la última versión estable).
* **SDK Mínimo:** API 24 (Android 7.0).
* **Target SDK:** API 36.

## ⚙️ Cómo ejecutar el proyecto
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto utilizando Android Studio.
3. Sincroniza el proyecto con los archivos de Gradle (Android Studio debería sugerirlo automáticamente).
4. Selecciona un emulador o conecta un dispositivo físico.
5. Haz clic en el botón de **Run** (Shift + F10) para compilar e instalar la aplicación.
