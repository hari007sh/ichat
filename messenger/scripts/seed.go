package main

import (
	"crypto/rand"
	"encoding/hex"
	"flag"
	"fmt"
)

func main() {
	users := flag.Int("users", 10, "number of users")
	region := flag.String("region", "IN", "region code")
	flag.Parse()
	fmt.Printf("Seeding %d users for region %s\n", *users, *region)
	for i := 0; i < *users; i++ {
		buf := make([]byte, 16)
		rand.Read(buf)
		fmt.Printf("user-%s\n", hex.EncodeToString(buf))
	}
}