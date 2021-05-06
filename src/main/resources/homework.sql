--> 1)
select * from users where (DATE_PART('day', now() - birth_date))/365 > 18 AND (DATE_PART('day', now() - birth_date))/365 < 25;

--> 2)
SELECT concat(users.name,' ', surname) AS User_full_name , count(owner) AS count_cars  FROM users INNER JOIN cars ON users.id = cars.owner GROUP BY users.name,surname,owner;

--> 3)


--> 4)
SELECT login FROM users JOIN cars c on users.id = c.owner GROUP BY login HAVING COUNT(owner)>=3;

--> 5)

SELECT DISTINCT dealer.name AS NAME_DILER, SUM(price) FROM dealer JOIN cars c on dealer.id = c.dealer_id GROUP BY dealer.name;

--> 6)
WITH  result AS (
    SELECT DISTINCT users.name, surname
    FROM users
             JOIN cars c on users.id = c.owner
    WHERE price > (SELECT AVG(price) FROM cars)
    GROUP BY users.name, users.name, surname, c.name, price
    HAVING COUNT(owner) >= 1
)
SELECT COUNT(*) FROM result;
