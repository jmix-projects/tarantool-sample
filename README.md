# Tarantool Sample

## Overview

The sample demonstrates how to work with data from [Tarantool](https://www.tarantool.io) database. 

Tarantool spaces are accessed using the [Spring Data Tarantool](https://github.com/tarantool/cartridge-springdata) library.

The sample project contains screens that display and save records to the Tarantool space called *products*.

The [TarantoolConfiguration.java](src/main/java/com/company/sample/TarantoolConfiguration.java) configures Spring Data Tarantool connection settings.

The [ProductRepository.java](src/main/java/com/company/sample/repository/ProductRepository.java) is a Spring Data repository that accesses Tarantool *products* space.

The [Product.java](src/main/java/com/company/sample/dto/Product.java) is an instance that is saved into Tarantool space.

## Stating the Tarantool Instance

Open the `tarantool` directory of the current project in the terminal.

Run Tarantool using Docker with the following command:

 ```
docker run --name mytarantool -p3301:3301 -d -v $(pwd):/opt/tarantool tarantool/tarantool tarantool /opt/tarantool/init.lua
 ```

The command will start a single Tarantool instance and execute instructions from the `init.lua` to create a *products* space.

## Known Issues and Limitations

Jmix data repositories must be disabled to avoid conflicts with Tarantool data repositories (see `application.properties` file):

```properties
jmix.core.data-repositories.enabled=false
```

Separate DTO classes are used for Jmix DTO entity and Tarantool instance returned from the Tarantool data repository: `Product` and `ProductModel`. We needed to do so, because Tarantool data repository tries to save all instance attributes to the database, but Jmix DTO entity contains service attributes like `_entityEntry` that should not be saved.