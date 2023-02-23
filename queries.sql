-- Part 1: Test it with SQL
id   INT
employer VARCHAR
name VARCHAR
skills VARCHAR
-- Part 2: Test it with SQL
SELECT name
FROM employer
WHERE location = "Saint Louis";
-- Part 3: Test it with SQL
DROP TABLE job;
-- Part 4: Test it with SQL
SELECT *
FROM skill
LEFT JOIN job ON skill.id = job.id
ORDER BY skill.name ASC