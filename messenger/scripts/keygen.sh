#!/usr/bin/env bash
set -euo pipefail
age-keygen -o age-master.key
vault kv put kv/e2e/master key=@age-master.key
libsignal-cli --username system generateIdentity --output identity.key