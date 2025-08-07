# Security Policy

## Incident Response Runbook
- Detect: PagerDuty alerts or user reports
- Triage: Security on-call within 15 minutes
- Contain: Revoke tokens, isolate impacted services via NetworkPolicy
- Eradicate: Patch, rotate keys with `./scripts/rotate.sh`
- Recover: Gradual traffic restore with canary deploys
- Postmortem: 24h blameless report, actions tracked to closure

## Key Rotation
Every 90 days run:
```
./scripts/rotate.sh --service realtime --env prod --dry-run=false
```

## Reporting Vulnerabilities
Email security@your-org.com or file a confidential Security Advisory.