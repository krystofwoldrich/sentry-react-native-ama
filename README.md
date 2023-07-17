# Sentry React Native AMA Demo

This is a demo app for a Sentry React Native Ask Me Anything live stream.

## How to Build for dev

```bash
npm run android
npm run ios
```

## How to Build for release

To successfully build the release version you need to update your Sentry project values in `ios/sentry.properties` and `android/sentry.properties` (you can create a free account at [Sentry.io](https://sentry.io/)) or use `SENTRY_ALLOW_FAILURE=true` environmental variable to allow the source map upload to Sentry to fail.
