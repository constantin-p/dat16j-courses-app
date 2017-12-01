-- Default user types
INSERT INTO usertypes (id, name) VALUES (1, 'STUDENT'), (2, 'TEACHER'), (3, 'ADMIN');

-- Demo account
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (1, 'admin@admin.com', 'John', '$2a$10$81P.BQe1hGREUWFKLtMOZOjlHITn4wUTIM0pIhUofykgK/N2hUngy', 'Smith', 3);
