package com.bugr.api.bugrapi.data

import com.bugr.api.bugrapi.models.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Users, Int>