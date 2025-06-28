START TRANSACTION;

CREATE DATABASE IF NOT EXISTS todolist;
USE todolist;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS task_categories;
DROP TABLE IF EXISTS todos;

SOURCE ./users.sql;
SOURCE ./task_categories.sql;
SOURCE ./todos.sql;

COMMIT;
