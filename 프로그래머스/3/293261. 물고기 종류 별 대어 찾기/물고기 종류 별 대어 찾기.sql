-- 코드를 작성해주세요
SELECT fi.ID, fiin.FISH_NAME, fi.LENGTH
FROM FISH_INFO fi
    INNER JOIN FISH_NAME_INFO fiin
    ON fi.FISH_TYPE = fiin.FISH_TYPE
WHERE (fi.FISH_TYPE, fi.LENGTH) 
    IN 
        (SELECT FISH_TYPE, MAX(LENGTH)
            FROM FISH_INFO
            GROUP BY FISH_TYPE
        )
        
ORDER BY 1 ASC;