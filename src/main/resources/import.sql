-- Default Study Programmes
INSERT INTO programmes (id, nameda, nameen) VALUES (1, 'Computer Science | DA', 'Computer Science');
INSERT INTO programmes (id, nameda, nameen) VALUES (2, 'Web Development | DA', 'Web Development');
INSERT INTO programmes (id, nameda, nameen) VALUES (3, 'Software development | DA', 'Software development');
INSERT INTO programmes (id, nameda, nameen) VALUES (4, 'IT-Security | DA', 'IT-Security');

-- Demo Courses
INSERT INTO courses (id, activities, ects_points, exam_form, exp_students, is_mandatory, language, max_students, min_students, nameda, nameen, outcome, prerequisites, content) VALUES (1, 'Individual work and exam. Communication takes place via our Ryver channel WD-2018-F-NODEJS', 10, 'Internal oral exam based on hand in product. Graded based on the 7-scale.', 35, 0, 'English', 50, 15, 'Full Stack NodeJs | DA', 'Full Stack NodeJs', 'Students will be able to code a full stack web based application, set-up a NODEJS server in the cloud and decide the best possible use of MongoDB', 'Students must know HTML, CSS, JS, PHP and MySQL.', 'NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON objects, Setting up a server in Amazon Web Servers and locally. Use of the terminal and FTP. Also, the setup and use of HTTPS.');

-- course_programme
INSERT INTO course_programme (course_id, programme_id) VALUES (1, 2);


-- Default user types
INSERT INTO usertypes (id, name) VALUES (1, 'ADMIN'), (2, 'TEACHER'), (3, 'STUDENT');

-- Demo accounts
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (1, 'admin@admin.com', 'John', '$2a$10$81P.BQe1hGREUWFKLtMOZOjlHITn4wUTIM0pIhUofykgK/N2hUngy', 'Smith', 1);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (2, 'teacher1@teacher.com', 'Jill', '$2a$10$sxwKeMujlbjwSH93lqvxBOdd9w7QnPQnvSovvGhw0adMc5P143Iha', 'Reyna', 2);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (3, 'teacher2@teacher.com', 'Donna', '$2a$10$nRT2NiN.90zY0wkwhT/OTu9LYOZzlyYe0NlIcMuV9y49XXmFLwWuS', 'Stiles', 2);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (4, 'teacher3@teacher.com', 'Randolph', '$2a$10$Ukku7ZdZ1qLbYd1jZSrcm.1gRorSwTya3c5tYQKyXPf8c.lmEQ6MO', 'Perkins', 2);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (5, 'student1@student.com', 'Edmond', '$2a$10$p/EylROtNZYQVeNHzT/D1ezFlkADitduqvJFNcuo3BU/cdRvKoYu6', 'McDonald', 3);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (6, 'student2@student.com', 'Annie', '$2a$10$hXcQjOyfYr2CGCs07sbnsOhx7jngrUDmAi.CabxNaNTVhbnmW3Bju', 'Wills', 3);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (7, 'student3@student.com', 'Anthony', '$2a$10$oyaNq9cF5sASzznyWaDLtegIY92MJFtPY0zqPpZtYv7Nx66QOe.1a', 'Hall', 3);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (8, 'john@smith.com', 'John', '$2a$10$Mqw.3nogV8q66Cms1vR8o.n1cAaG5zdRpe.TyoBtyZFqKu97tDxAK', 'Smith', NULL);
