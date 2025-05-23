package com.artemchep.keyguard.common.model

import arrow.core.Either
import com.artemchep.keyguard.feature.localization.TextHolder
import com.artemchep.keyguard.platform.LeBiometricCipher

sealed interface PureBiometricAuthPrompt

class BiometricAuthPrompt(
    val title: TextHolder,
    val text: TextHolder? = null,
    val cipher: LeBiometricCipher,
    val requireConfirmation: Boolean,
    /**
     * Called when the user either failed the authentication or
     * successfully passed it.
     */
    val onComplete: (
        result: Either<BiometricAuthException, LeBiometricCipher>,
    ) -> Unit,
) : PureBiometricAuthPrompt

class BiometricAuthPromptSimple(
    val title: TextHolder,
    val text: TextHolder? = null,
    val requireConfirmation: Boolean,
    /**
     * Called when the user either failed the authentication or
     * successfully passed it.
     */
    val onComplete: (
        result: Either<BiometricAuthException, Unit>,
    ) -> Unit,
) : PureBiometricAuthPrompt
