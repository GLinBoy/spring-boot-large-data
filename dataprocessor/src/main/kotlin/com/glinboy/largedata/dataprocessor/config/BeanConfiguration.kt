package com.glinboy.largedata.dataprocessor.config

import com.glinboy.largedata.dataprocessor.client.DataProviderServiceApi
import com.glinboy.largedata.dataprocessor.client.impl.DataProviderRestServiceImpl
import com.glinboy.largedata.dataprocessor.client.impl.DataProviderRestServiceNormalImpl
import com.glinboy.largedata.dataprocessor.repository.ReviewRepository
import com.glinboy.largedata.dataprocessor.service.processor.*
import com.glinboy.largedata.dataprocessor.service.processor.impl.*
import com.glinboy.largedata.shared.dto.ReviewDTO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaTemplate
import java.io.File

@Configuration
class BeanConfiguration {


    @Bean
    fun dataProviderRestServiceImplBean(): DataProviderServiceApi<File> =
        DataProviderRestServiceImpl()

    @Bean
    fun dataProviderRestServiceNormalImplBean(): DataProviderServiceApi<List<ReviewDTO>> =
        DataProviderRestServiceNormalImpl()

    @Bean
    fun reviewHandlerImplBean(
        saveProcess: SaveProcess<ReviewDTO>,
        publishProcess: PublishProcess<ReviewDTO>
    ):
        ReviewHandler<Process<ReviewDTO>, ReviewDTO> =
        ReviewHandlerImpl(saveProcess, publishProcess)

    @Bean
    fun reviewHandlerNormalImplBean(
        deleteProcess: DeleteProcess<List<ReviewDTO>>,
        saveProcess: SaveProcess<List<ReviewDTO>>,
        publishProcess: PublishProcess<List<ReviewDTO>>
    ):
        ReviewHandler<Process<List<ReviewDTO>>, List<ReviewDTO>> =
        ReviewHandlerNormalImpl(deleteProcess, saveProcess, publishProcess)

    @Bean
    fun saveProcessImplBean(reviewRepository: ReviewRepository): SaveProcess<ReviewDTO> =
        SaveProcessImpl(reviewRepository)

    @Bean
    fun saveProcessNormalImplBean(reviewRepository: ReviewRepository): SaveProcess<List<ReviewDTO>> =
        SaveProcessNormalImpl(reviewRepository)

    @Bean
    fun publishProcessImplBean(kafkaTemplate: KafkaTemplate<String, ReviewDTO>): PublishProcess<ReviewDTO> =
        PublishProcessImpl(kafkaTemplate)

    @Bean
    fun publishProcessNormalImplBean(kafkaTemplate: KafkaTemplate<String, ReviewDTO>): PublishProcess<List<ReviewDTO>> =
        PublishProcessNormalImpl(kafkaTemplate)

    @Bean
    fun deleteProcessImplBean(reviewRepository: ReviewRepository): DeleteProcess<ReviewDTO> =
        DeleteProcessImpl(reviewRepository)

    @Bean
    fun deleteProcessNormalImplBean(reviewRepository: ReviewRepository): DeleteProcess<List<ReviewDTO>> =
        DeleteProcessNormalImpl(reviewRepository)
}
