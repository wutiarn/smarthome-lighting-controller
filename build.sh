set -e
docker build -t quay.io/wutiarn/smarthome-lighting-controller .
docker push quay.io/wutiarn/smarthome-lighting-controller
