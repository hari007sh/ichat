#!/usr/bin/env bash
set -euo pipefail
SERVICE=""
ENVIRONMENT=""
DRY_RUN=true

while [[ $# -gt 0 ]]; do
  case $1 in
    --service) SERVICE="$2"; shift 2;;
    --env) ENVIRONMENT="$2"; shift 2;;
    --dry-run=*) DRY_RUN="${1#*=}"; shift 1;;
    *) echo "Unknown arg: $1"; exit 1;;
  esac
done

echo "Rotating keys for service=$SERVICE env=$ENVIRONMENT dry_run=$DRY_RUN"
# Placeholder for KMS/Vault rotation steps