#!/usr/bin/env bash
set -euo pipefail
age-keygen -o identity.key
age-keygen -y identity.key > identity.pub