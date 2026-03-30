# Stackable Items & Better Potions Mod (Minecraft 1.20.1 Fabric)

Este mod mejora significativamente el sistema de pociones de Minecraft, permitiendo que sean stackeables y añadiendo nuevos niveles y duraciones.

## Características Principales

### 1. Pociones Stackeables
- Todas las pociones (normales, arrojadizas y persistentes) se pueden stackear hasta **64**.
- **Manejo inteligente de botellas**: Al beber una poción de un stack, la botella vacía se coloca automáticamente en tu inventario o se suelta si este está lleno, manteniendo el stack de pociones en tu mano.

### 2. Nuevos Niveles de Pociones (Nivel III)
Se ha añadido un tercer nivel para las pociones con efectos de intensidad:
- **Pociones incluidas**: Velocidad, Fuerza, Regeneración, Veneno, Lentitud, Salto, Curación y Daño.
- **Obtención**: Se consiguen usando **Glowstone Dust** sobre una poción de Nivel II en el soporte de pociones (Brewing Stand).
- **Duración base Nivel III**: 3:00 minutos (o efecto instantáneo potenciado).

### 3. Duraciones Personalizadas
- **Pociones de Nivel II**: Tienen una duración de **2:00 minutos** (30 segundos extra sobre el valor vanilla).
- **Pociones de Nivel III**: Tienen una duración de **1:30 minutos**.
- **Otras pociones**: Mantienen sus duraciones vanilla originales.

## Recetas de Alquimia (Brewing)

| Entrada | Ingrediente | Resultado | Duración |
|---------|-------------|-----------|----------|
| Poción Nivel II | Glowstone Dust | **Poción Nivel III** | 1:30 |
| Poción Base | Redstone | **Poción Extendida** | 8:00 |

## Detalles Técnicos (Mixins Utilizados)

El mod utiliza varios Mixins para modificar el comportamiento base de Minecraft de forma eficiente:

- **`ItemMixin`**: Intercepta `getMaxCount()` para devolver 64 en todos los tipos de pociones.
- **`PotionItemMixin`**: Gestiona la devolución de botellas vacías al inventario para no romper los stacks.
- **`PotionDurationMixin`**: Modifica dinámicamente las duraciones de las pociones al ser inicializadas.
- **`BrewingRecipeRegistryAccessor`**: Permite registrar nuevas recetas de alquimia personalizadas.

## Requisitos
- Minecraft 1.20.1
- Fabric Loader
- Fabric API
