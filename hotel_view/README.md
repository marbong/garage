# hotel-view

## nginx ��� �� ���� ����/���� ���
```
sudo npm install -g @vue/cli
sudo npm install
sudo npm run build
cp -R ./dist/* /{nginx ���}
```

### ��Ŀ ��� �� ���� ���
```
docker build -t {�̹����̸�}:{����}.
docker run -it -p 80:80 --rm --name hotel-front {�̹����̸�}:{����}
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
