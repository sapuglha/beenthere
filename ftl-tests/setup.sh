#!/bin/sh

if [ "$GCLOUD_SERVICE_KEY" = "" ]; then
  echo "GCLOUD_SERVICE_KEY env variable is empty. Exiting."
  exit 1
fi

# Export to secrets file
echo $GCLOUD_SERVICE_KEY | base64 -di > client-secret.json

# Set project ID
gcloud config set project sapuglha-app-beenthere

# Auth account
gcloud auth activate-service-account firebase-ftl@sapuglha-app-beenthere.iam.gserviceaccount.com --key-file client-secret.json

# Delete secret
rm client-secret.json
