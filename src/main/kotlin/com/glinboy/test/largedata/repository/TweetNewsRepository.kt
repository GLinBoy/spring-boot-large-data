package com.glinboy.test.largedata.repository

import com.glinboy.test.largedata.entity.TweetNews
import org.springframework.data.jpa.repository.JpaRepository

interface TweetNewsRepository : JpaRepository<TweetNews, Long> {
}
