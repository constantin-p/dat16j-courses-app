-- Default user types
INSERT INTO usertypes (id, name) VALUES (1, 'ADMIN'), (2, 'TEACHER'), (3, 'STUDENT');

-- Demo accounts
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (1, 'admin@admin.com', 'John', '$2a$10$81P.BQe1hGREUWFKLtMOZOjlHITn4wUTIM0pIhUofykgK/N2hUngy', 'Smith', 1);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (2, 'teacher@teacher.com', 'John', '$2a$10$SVBlf/.wozw22QERM9CBx.d2fvnEf8Ss0clY3NHnFFhWEz7gCkCKa', 'Smith', 2);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (3, 'student@student.com', 'John', '$2a$10$tSbOJdAxbuTjvazbfAbFteBA4SEFdzDGm8zALuDBjfvDJFSwxFObq', 'Smith', 3);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (4, 'john@smith.com', 'John', '$2a$10$Mqw.3nogV8q66Cms1vR8o.n1cAaG5zdRpe.TyoBtyZFqKu97tDxAK', 'Smith', NULL);
