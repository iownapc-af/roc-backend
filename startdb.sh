sudo docker rm -v -f portfolio-db
sudo docker run -p 5432:5432 --name portfolio-db --user postgres -e POSTGRES_PASSWORD=1234 -d postgres