#!/bin/sh

# Run tests on test lab
gcloud firebase test android run \
    --type instrumentation \
    --app app/build/outputs/apk/debug/app-debug.apk \
    --test app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk \
    --device model=NexusLowRes,version=23,locale=en_US,orientation=portrait \
    --device model=NexusLowRes,version=24,locale=en_US,orientation=portrait \
    --device model=NexusLowRes,version=25,locale=en_US,orientation=portrait \
    --device model=NexusLowRes,version=26,locale=en_US,orientation=portrait \
    --device model=NexusLowRes,version=27,locale=en_US,orientation=portrait \
    --timeout 30m \
    --no-record-video \
    --no-performance-metrics
