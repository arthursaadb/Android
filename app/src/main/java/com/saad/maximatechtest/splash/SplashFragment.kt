package com.saad.maximatechtest.splash

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saad.maximatechtest.R
import com.saad.maximatechtest.databinding.FragmentGatewayBinding
import com.saad.maximatechtest.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        animateImage()
    }

    private fun animateImage() {
        val alphaAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = TIME_LOGO_ANIMATION
        }

        alphaAnimator.addUpdateListener {
            val animationAlpha = it.animatedValue as Float

            binding.logoSplash.alpha = animationAlpha
        }

        alphaAnimator.doOnEnd {
            navController.navigate(R.id.action_splashFragment_to_gatewayFragment)
        }

        alphaAnimator.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TIME_LOGO_ANIMATION = 2000L
    }
}