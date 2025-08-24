#!/usr/bin/env sh
DIR="$(cd "$(dirname "$0")" && pwd)"
if [ ! -f "$DIR/gradle/wrapper/gradle-wrapper.jar" ]; then
  if command -v gradle >/dev/null 2>&1; then
    gradle -p "$DIR" wrapper --gradle-version 8.4
  fi
fi
exec "$DIR/gradlew" "$@"