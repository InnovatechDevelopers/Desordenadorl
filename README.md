DESORDENADORL
=========
![Maintenance](https://img.shields.io/maintenance/yes/2023)  [![codebeat badge](https://codebeat.co/badges/7ccb76f8-05e8-4d01-85b7-4f70286f954c)](https://codebeat.co/projects/github-com-innovatechdevelopers-desordenadorl-main)  ![GitHub repo size](https://img.shields.io/github/repo-size/InnovatechDevelopers/Desordenadorl?style=plastic)

Implementación **JAVA** para control de stock de la conocida tienda de Andorra **Desordenadorl (2023).**

<div style="text-align:center"><img src="docs\terminal.png" ,width=600/></div>

### General
<p align="justify">
Gestión de PYMES de venta de productos con un stock máximo estimado de 1.000.000 de productos en total.

Se plantea la siguiente tabla de productos como productos iniciales en stock. Con esta catalogación, dado el acuerdo obtenido con el cliente, se cubre tanto el stock actual como el futuro a corto/medio plazo.

|     IdProducto    |     Familia        |     Subfamilia              |     Tipo                |
|-------------------|--------------------|-----------------------------|-------------------------|
|     C01           |     Ordenador      |     Sobremesa               |                         |
|     C02           |     Ordenador      |     All-in-one              |                         |
|     C03           |     Ordenador      |     Portátil                |                         |
|     P01           |     Periférico     |     Ratón                   |     Alámbrico           |
|     P02           |     Periférico     |     Ratón                   |     Inalámbrico         |
|     P03           |     Periférico     |     Ratón                   |     Gamming             |
|     P04           |     Periférico     |     Teclado                 |     Alámbrico           |
|     P05           |     Periférico     |     Teclado                 |     Alámbrico + DNIe    |
|     P06           |     Periférico     |     Teclado                 |     Inalámbrico         |
|     P07           |     Periférico     |     Teclado                 |     Gamming             |
|     P08           |     Periférico     |     Monitor                 |     24”                 |
|     P09           |     Periférico     |     Monitor                 |     27”                 |
|     P10           |     Periférico     |     Monitor                 |     Otras “             |
|     P11           |     Periférico     |     Impresora               |     Tinta               |
|     P12           |     Periférico     |     Impresora               |     Láser               |
|     P13           |     Periférico     |     Impresora               |     Otras               |
|     I01           |     Componentes    |     Placa Base              |     Intel               |
|     I02           |     Componentes    |     Placa Base              |     AMD                 |
|     I03           |     Componentes    |     Procesador              |     Intel               |
|     I04           |     Componentes    |     Procesador              |     AMD                 |
|     I05           |     Componentes    |     Tarjetas Gráficas       |     nVidia              |
|     I06           |     Componentes    |     Tarjetas Gráficas       |     Gamming             |
|     I07           |     Componentes    |     Tarjetas Gráficas       |     Otras               |
|     I08           |     Componentes    |     Fuentes alimentación    |     < 650W              |
|     I09           |     Componentes    |     Fuentes alimentación    |     >= 650W             |
|     I10           |     Componentes    |     Tarjetas sonido         |     Otras               |



### Requerimientos

Código esta implementado en uso de Oracle JDK 19.0. 
Para el correcto funcionamiento del interfaz gráfico se utiliza actualmente una terminal windows bajo uso de PowerShell. No se ha previsto el uso de WSL en la aplicación.

```
Windows             11
oracle JDK          19.0
```

### Distribución del proyecto
<p align="justify">
Se presenta el proyecto desde un repositorio privado de la empresa para cumplir con los siguientes objetivos:

Portabilidad: 
El proyecto permite ejecutarse en diferentes plataformas, aunque se ha acordado Windows como plataforma final. El generar un ejecutable puede limitar su portabilidad.

Flexibilidad: El proyecto es más flexible en términos de configuración y personalización. Esto nos permite ajustar el proyecto según nos determine el cliente.

Mantenimiento/modificación más sencillo: 
Las actualizaciones (o incluso correcciones) que deben aplicarse al proyecto, tras la evaluación del cliente del mismo.

Facilidad de despliegue: Al no generar un ejecutable, el proyecto puede ser más fácil de desplegar en entornos de servidor o en la nube. En lugar de tener que distribuir y ejecutar un único archivo ejecutable, los componentes del proyecto pueden desplegarse como archivos individuales que se pueden configurar y actualizar de forma independiente.

Uso de almacenamiento: En el punto actual de entrega no se ha determinado aún un almacenamiento definitivo, por lo que el proyecto usa  de persistencia para los datos, estando a la espera de la definición del cliente.
