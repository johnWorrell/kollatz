# kollatz# Collatz Kotlin Project

A simple Kotlin project that computes Collatz sequences from the command line. Includes tests and GitHub Actions CI.

## Running
```sh
./gradlew run --args=7
```

## Testing
```sh
./gradlew test
```

## Collatz Function
Given a positive integer:
- If even → divide by 2
- If odd → compute `3n + 1`
- Repeat until reaching 1

Example:
```
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

## CI
GitHub Actions workflow runs automatically on pushes and pull requests.