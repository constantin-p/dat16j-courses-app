-- Default Study Programmes
INSERT INTO programmes (id, nameda, nameen) VALUES (1, 'Computer Science | DA', 'Computer Science');
INSERT INTO programmes (id, nameda, nameen) VALUES (2, 'Web Development | DA', 'Web Development');
INSERT INTO programmes (id, nameda, nameen) VALUES (3, 'Software development | DA', 'Software development');
INSERT INTO programmes (id, nameda, nameen) VALUES (4, 'IT-Security | DA', 'IT-Security');

-- Demo Courses
INSERT INTO courses (id, activities, ects_points, exam_form, exp_students, is_mandatory, language, max_students, min_students, nameda, nameen, outcome, prerequisites) VALUES (1, 'Individual work and exam. Communication takes place via our Ryver channel WD-2018-F-NODEJS', 10, 'Internal oral exam based on hand in product. Graded based on the 7-scale.', 35, 0, 'English', 50, 15, 'Full Stack NodeJs | DA', 'Full Stack NodeJs', 'Students will be able to code a full stack web based application, set-up a NODEJS server in the cloud and decide the best possible use of MongoDB', 'Students must know HTML, CSS, JS, PHP and MySQL.');

-- course_programme
INSERT INTO course_programme (course_id, programme_id) VALUES (1, 2);


-- Default user types
INSERT INTO usertypes (id, name) VALUES (1, 'ADMIN'), (2, 'TEACHER'), (3, 'STUDENT');

-- Demo accounts
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (1, 'admin@admin.com', 'John', '$2a$10$81P.BQe1hGREUWFKLtMOZOjlHITn4wUTIM0pIhUofykgK/N2hUngy', 'Smith', 1);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (2, 'teacher@teacher.com', 'John', '$2a$10$SVBlf/.wozw22QERM9CBx.d2fvnEf8Ss0clY3NHnFFhWEz7gCkCKa', 'Smith', 2);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (3, 'student@student.com', 'John', '$2a$10$tSbOJdAxbuTjvazbfAbFteBA4SEFdzDGm8zALuDBjfvDJFSwxFObq', 'Smith', 3);
INSERT INTO users (id, email, first_name, hash, last_name, type_id) VALUES (4, 'john@smith.com', 'John', '$2a$10$Mqw.3nogV8q66Cms1vR8o.n1cAaG5zdRpe.TyoBtyZFqKu97tDxAK', 'Smith', NULL);

