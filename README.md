# KillTheMace

KillTheMace is a lightweight custom Minecraft plugin developed for Paper/Spigot servers.  
It introduces a controlled PvE/PvP arena mechanic inside **the End dimension**, where player damage is automatically moderated to maintain balanced and fair gameplay.

## Overview
The plugin defines an arena centred in `world_the_end` at specific coordinates.  
Within a 60-block radius around this point, any damage dealt by players is capped to a maximum of **70 hit points**.  
This prevents overpowered weapons, enchantments, or custom damage sources from unbalancing the fight while keeping the combat intense and competitive.

## Features
- Automatic detection of players fighting within the arena region.
- Damage capping system to keep battles fair and engaging.
- Configurable arena location and radius (modifiable in the codebase).
- Optimised for performance and minimal server overhead.

## Technical
- **Minecraft:** Spigot/Paper 1.21.1  
- **Language:** Java 21  
- **Build Tool:** Maven  

## Installation
1. Build the plugin with Maven (`mvn clean package`) or use a pre-compiled JAR.  
2. Place the JAR into your server’s `plugins/` directory.  
3. Restart the server.  
4. Ensure you have a world named `world_the_end`, as the arena is bound to this world.  

---

## Author
Developed by **Penta** as part of ongoing Minecraft server plugin development.
