dev-up:
	docker compose -f infra/docker-compose.yml up -d
seed:
	go run ./scripts/seed.go --users 100 --region IN
test-e2ee:
	npx playwright test tests/e2e/encrypt_flow.spec.ts
open-local:
	open http://localhost:3000