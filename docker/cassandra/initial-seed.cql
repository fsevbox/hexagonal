CREATE KEYSPACE IF NOT EXISTS hexagonal WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE hexagonal;
