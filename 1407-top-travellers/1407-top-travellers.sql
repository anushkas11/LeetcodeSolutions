# Write your MySQL query statement below
Select e.name, IFNULL(SUM(r.distance), 0) as travelled_distance
from Users e
Left join Rides r on e.id=r.user_id
group by e.id
Order by travelled_distance desc,e.name ASC;