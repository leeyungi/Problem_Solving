SELECT b.BOOK_ID, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK b
WHERE b.CATEGORY = "인문"
  and b.PUBLISHED_DATE LIKE "2021%"
ORDER BY b.PUBLISHED_DATE