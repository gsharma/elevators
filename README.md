# Elevator Scheduler

## Goals

0. For users: minimize the transit time (wait time outside + wait time inside) while using the elevator.
1. For operators: minimize operational energy expenditure, allow for easy maintenance, allow configurability.


## Motivation

On a recent trip to Hawaii while staying in a large high-rise building with a bank of 5 elevators, I closely observed the building's elevator scheduler in action and decided to simulate one myself.


## System Requirements

Note: list needs to be segregated by user vs operator requirements::
0. Capacity is enforced as an upper bound on the aggregate weight of users riding an elevator.
1. Direction of elevator motion does not change until current destination.
2. Service speed of a group of elevators managed by a scheduler is identical.
3. Service capcity of a group of elevators managed by a scheduler may not be uniform.
4. Service speed and capacity are always known to the elevator scheduler.
5. Elevator-internal and elevator-external requests need to be separately identified.
6. Resting point of elevators should be one of the floors with highest external request count.
7. Elevator-internal requests should not ignored and are serviced by the local elevator.
8. Elevator-internal requests can be toggled between selected/deslected states.
9. Duplicate requests for the same floor are ignored.
10. Elevator-external requests are scheduled by the elevator scheduler.
11. Elevator has 3 operational modes - normal, emergency, stopped.
12. Emergency op mode disables all external scheduling.
13. Operators may choose to disable scheduling for certain floors (eg. floor 13).


## System Invariants

0. 


## Implementation Notes


