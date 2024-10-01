SELECT Id
FROM Weather w1
WHERE temperature > (
    SELECT temperature
    FROM Weather w2
    WHERE w2.RecordDate = DATE_SUB(w1.RecordDate, INTERVAL 1 DAY)
);