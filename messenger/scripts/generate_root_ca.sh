#!/usr/bin/env bash
set -euo pipefail
openssl req -x509 -new -nodes -subj "/CN=messenger-root-ca" -keyout rootCA.key -sha256 -days 3650 -out rootCA.crt