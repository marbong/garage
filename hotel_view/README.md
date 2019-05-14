# hotel-view

## nginx 사용 시 수동 빌드/배포 방법
```
sudo npm install -g @vue/cli
sudo npm install
sudo npm run build
cp -R ./dist/* /{nginx 경로}
```

### 도커 사용 시 배포 방법
```
docker build -t {이미지이름}:{버전}.
docker run -it -p 80:80 --rm --name hotel-front {이미지이름}:{버전}
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
